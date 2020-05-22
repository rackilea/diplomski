matrixentry = rowArray[row];

    while (null != maxtrixentry && matrixentry.getColumn() < col) {
         matrixentry = matrixentry.getNextColumn();
    }

    if (null == maxtrixentry || matrixentry.getColumn() > col){
        return 0;
    }
    result = matrixentry.getData();