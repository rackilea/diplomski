case '*':
        ch = next();
        if (ch == '?') {
            next();
            return new Curly(prev, 0, MAX_REPS, LAZY);
        } else if (ch == '+') {
            next();
            return new Curly(prev, 0, MAX_REPS, POSSESSIVE);
        }
        return new Curly(prev, 0, MAX_REPS, GREEDY);