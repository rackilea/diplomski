char c;
         int val;
        do {
            val = inputReader.read();
            // do this if you want, you don't have to
            c = (char) val;
            if ((c == CARRIAGE_RETURN || c == START_OF_MESSAGE) &&
                message.length() == 0)
            else if (c != END_OF_MESSAGE && ((short)c) != -1)
                // ein Byte "Nutzlast"
                message.append(c);
        } while (c != END_OF_MESSAGE && val != -1);