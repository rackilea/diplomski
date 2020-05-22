final List<String> xpaths = new ArrayList<String>();

    DifferenceListener myDifferenceListener = new DifferenceListener() {

        public void skippedComparison(Node arg0, Node arg1) {
            // Do nothing
        }

        public int differenceFound(Difference pDifference) {
            xpaths.add(pDifference.getControlNodeDetail().getXpathLocation());
            return RETURN_ACCEPT_DIFFERENCE;
        }
    };

    Diff myDiff = new Diff(xmlDoc1, xmlDoc2);
    myDiff.overrideDifferenceListener(myDifferenceListener);
    myDiff.similar();
    return paths;