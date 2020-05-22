byte [] bytes = new byte[] {1,2};

        System.out.println( (bytes[0] & 0xff) + ((bytes[1] & 0xff) << 8));
        System.out.println( bytes[0] & 0xff + ((bytes[1] & 0xff) << 8));
        System.out.println( (bytes[0] & 0xff) + (bytes[1] & 0xff) << 8);
        System.out.println( (bytes[0] & 0xff) + (bytes[1] & 0xff << 8));