final int input = 30;
final int numberOfPieces = 4;    

final int quotient = input / numberOfPieces;
final int remainder = input % numberOfPieces;

int [] results = new int[numberOfPieces];
for( int i = 0; i < numberOfPieces; i++ ) {
    results[i] = i < remainder ? quotient + 1 : quotient;
}