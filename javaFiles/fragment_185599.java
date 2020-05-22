socket = java.net.MultiSocket(streamPort);
socket.joinGroup(java.net.InetAddress.getByName(streamIP));
socket.setReuseAddress(1);

packet = java.net.DatagramPacket(zeros(1, intmax('uint16'), 'int8'), intmax('uint16'));

socket.receive(packet);

socket.leaveGroup(InetAddress.getByName(streamIP));
socket.close;

msg = packet.getData;
msg = msg(1:packet.getLength);