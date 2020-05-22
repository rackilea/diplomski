Sound sound = Sound.class.getResource(filename);

System.out.println(sound);
System.out.println(filename);

if (filename != null && sound != null) clip = Applet.newAudioClip(sound);