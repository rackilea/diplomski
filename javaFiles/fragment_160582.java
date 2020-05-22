if (inline_depth() > MaxInlineLevel) {
        return "inlining too deep";
    }
    if (method() == callee_method
            && inline_depth() > MaxRecursiveInlineLevel) {
        return "recursively inlining too deep";
    }