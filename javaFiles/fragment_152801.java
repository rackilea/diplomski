int i = -1;
while ((i = br.read()) != -1) {
     char c = (char)i;
     for (int i = 0; i <= size; ++i) {
        if (size == 0) {
            characters[i] = c;
            charCount[i]++;
            size++;
            System.out.println("Letter/Count: " + characters[i] + "/" + charCount[i]);
            break;
        }

        if (characters[i] == c) {
            charCount[i]++;
            break;
        } else if (i == size) {
            characters[i] = c;
            charCount[i]++;
            size++;
            System.out.println("Letter/Count: " + characters[i] + "/" + charCount[i]);
            break;
        }
    }
}