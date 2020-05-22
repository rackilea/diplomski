else {
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        sentence = new String(receivePacket.getData());
        output.write(sentence.getBytes());
        }