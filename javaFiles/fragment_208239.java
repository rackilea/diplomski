System.out.println("Which song would you like to play?(Beethoven's Moonlight Sonata, Beethoven's Fur Elise, or Chopin's March Funebre): Type m for Moonlight Sonata, f for Fur Elise, or r for March Funebre.");
char b = input.next().trim().charAt(0); 
switch(b) {
    case 'm': System.out.println("This song is played in C# minor and the first three notes are: G#, C#, and E");
              break;
    case 'f': System.out.println("This song was written in A minor with the first two notes being E and D#");
              break;
    case 'r': System.out.println("This classic, otherwise known as The Funeral March, is to be played in Bb minor, however it can be very tricky!");
              break;
}