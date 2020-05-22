for (int m = 0; n < 200; m++) {
     for(int n = 1; n < 100; n++) {
        OriginalArrayOfNode[m][n].head = OriginalArrayOfNode[m][0].head;
        OriginalArrayOfNode[m][n].left = OriginalArrayOfNode[m][0].left;
        //etc
     }
}