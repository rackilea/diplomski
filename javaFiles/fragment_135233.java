for(int i = 0; i < s.length(); ++i) {
    if(s.charAt(i) == '1') {
        // in case we were just keeping track of 0's
        maxBlock = Math.max(maxBlock, temp0Count);
        temp0Count = 0;

        temp1Count++;
    }
    else {
        // in case we were just keeping track of 1's
        maxBlock = Math.max(maxBlock, temp1Count);
        temp1Count = 0;

        temp0Count++;
    }
}