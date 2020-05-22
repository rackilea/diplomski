else if (c1String.equals("@") || c2String.equals("@")) {
            return areTheSame(x.substring(1), y.substring(1));
        }

        else if (c1String.equals("*") || c2String.equals("*")){
            return true;
        }