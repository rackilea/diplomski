while (in.hasNext()) {
    words = in.next();

    if (words.matches(alphaRegex)) {
        numberWords++;
        message = "The name is "+words+"\n";
        JOptionPane.showMessageDialog (null, message);

    } else if (words.matches(numRegex)) {
        countNumber++;
        num = words; // instead of num = in.next()
        message = "The number is "+num+"\n";
        JOptionPane.showMessageDialog (null, message);
    }
}