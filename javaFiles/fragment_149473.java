// Rounding required?  Check for argument reduction!
  if (Matcher::strict_fp_requires_explicit_rounding) {
    // (snip)

    // Pseudocode for sin:
    // if (x <= Math.PI / 4.0) {
    //   if (x >= -Math.PI / 4.0) return  fsin(x);
    //   if (x >= -Math.PI / 2.0) return -fcos(x + Math.PI / 2.0);
    // } else {
    //   if (x <=  Math.PI / 2.0) return  fcos(x - Math.PI / 2.0);
    // }
    // return StrictMath.sin(x);

    // (snip)

    // Actually, sticking in an 80-bit Intel value into C2 will be tough; it
    // requires a special machine instruction to load it.  Instead we'll try
    // the 'easy' case.  If we really need the extra range +/- PI/2 we'll
    // probably do the math inside the SIN encoding.

    // Make the merge point
    RegionNode* r = new RegionNode(3);
    Node* phi = new PhiNode(r, Type::DOUBLE);

    // Flatten arg so we need only 1 test
    Node *abs = _gvn.transform(new AbsDNode(arg));
    // Node for PI/4 constant
    Node *pi4 = makecon(TypeD::make(pi_4));
    // Check PI/4 : abs(arg)
    Node *cmp = _gvn.transform(new CmpDNode(pi4,abs));
    // Check: If PI/4 < abs(arg) then go slow
    Node *bol = _gvn.transform(new BoolNode( cmp, BoolTest::lt ));
    // Branch either way
    IfNode *iff = create_and_xform_if(control(),bol, PROB_STATIC_FREQUENT, COUNT_UNKNOWN);
    set_control(opt_iff(r,iff));

    // Set fast path result
    phi->init_req(2, n);

    // Slow path - non-blocking leaf call
    Node* call = NULL;
    switch (id) {
    case vmIntrinsics::_dsin:
      call = make_runtime_call(RC_LEAF, OptoRuntime::Math_D_D_Type(),
                               CAST_FROM_FN_PTR(address, SharedRuntime::dsin),
                               "Sin", NULL, arg, top());
      break;

      break;
    }