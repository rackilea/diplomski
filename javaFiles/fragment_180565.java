try {
        new Socket("stackoverflow.com", 80);
    } catch (IOException e) {
        // something is wrong, not necessarily firewall problem
        ... 
    }

    // no firewall