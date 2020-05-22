//load and start audio
AudioClip ac = Applet.newAudioClip(url);
ac.play();

System.out.println("Press any key to exit.");
//keep thread alive until a key is pressed
System.in.read();
ac.stop();