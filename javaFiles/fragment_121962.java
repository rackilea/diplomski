//looping over all Q commands
        while(Q>0) {

            s = in.nextLine();
            str = s.split(" ");
            //command - command code
            //RangeL,RangeR - range of coins which are affected
            command = Integer.parseInt(str[0]);
            RangeL = Integer.parseInt(str[1]);
            RangeR = Integer.parseInt(str[2]);