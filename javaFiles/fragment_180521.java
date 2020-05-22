public Solution[] getReferenceSolution(Problem p) {

        int personalityVal = 1;
        int templateNameVal = 0;
        ...
        Solution[] res = new Solution[2];
        res[0] = getComponentFactory().constructSolution(personalityVal);
        res[1] = getComponentFactory().constructSolution(templateNameVal);
        ...

        return res;
    }