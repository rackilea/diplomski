static void writeMipSolution(glp_prob lp) {

 String name = GLPK.glp_get_obj_name(lp);
 double val = GLPK.glp_mip_obj_val(lp);

 System.out.println(name + " = " + val);

 int n = GLPK.glp_get_num_cols(lp);

 for (int i = 1; i <= n; i++) {
     name = GLPK.glp_get_col_name(lp, i);
     val = GLPK.glp_mip_col_val(lp, i);
     System.out.println(name + " = " + val);
 }
}