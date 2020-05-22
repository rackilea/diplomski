System.out.println("Type password");
myPass = fromUser.readLine() + System.lineSeparator();
toServer.writeBytes(myPass);


System.out.println("Type address");
myAd = fromUser.readLine() + System.lineSeparator();
toServer.writeBytes(myAd);