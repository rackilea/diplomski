if (call->is_AllocateArray()) {
      if (!cik->is_array_klass()) { // StressReflectiveCode
        es = PointsToNode::GlobalEscape;
      } else {
        int length = call->in(AllocateNode::ALength)->find_int_con(-1);
        if (length < 0 || length > EliminateAllocationArraySizeLimit) {
          // Not scalar replaceable if the length is not constant or too big.
          scalar_replaceable = false;
        }
      }