while (true) {

            for (Input input : inputs) {

                try {

                        input.readSomething();

                } catch (EndOfStreamException e) {

                    closePort(input.getPort()); 
                    break;
                }
            }

        }