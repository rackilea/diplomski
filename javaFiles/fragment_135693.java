@Override
        public Boolean visitTypeVar(TypeVar t, Type s) {
            switch (s.tag) {
            case ERROR:
            case BOT:
                return true;
            case TYPEVAR:
                if (isSubtype(t, s)) {
                    return true;
                } else if (isCastable(t.bound, s, Warner.noWarnings)) {
                    warnStack.head.warn(LintCategory.UNCHECKED);
                    return true;
                } else {
                    return false;
                }
            default:
                return isCastable(t.bound, s, warnStack.head);
            }
        }