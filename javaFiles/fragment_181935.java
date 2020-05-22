for(int key=0; key<=100; key++) {
        for(int i=0; i<message.length(); i++) {
            ascii = ( (int)newmessage[i] + 127) - 32;
            if(ascii - key > 126)
                decoded[i] = (char)((int)newmessage[i] - key);
            else
                decoded[i] = (char)((((int)newmessage[i] - key) +127) -32);
        }
        System.out.println("Decoded with i=" +key +":"+new String(decoded)); // For check what is the correct message. 
    }