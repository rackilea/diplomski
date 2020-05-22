public static void main(String[] args) throws Exception {
    String encodeImage = 
    "iVBORw0KGgoAAAANSUhEUgAAABQAAAAWCAYAAADAQbwGAAAABHNCSVQICAgIfAhkiAAAAilJREFU\n" + 
    "OI2llE1IVGEUhp+Z0AhkHPpzZspGN4kmltUYYmKTJC0kkgQxzEhhIsp+sFUtomUg06IiCoICoU3K\n" + 
    "UCTE3dQmgkpoiGyMFk2CMCEtpFnYyNvCcex273UudFbf5bzn4bznHK5HkigS375/pbRkDcFAVTEp\n" + 
    "yEWcHzorl1K5UgEClJr+/P/AwaMdBaCbLosq/oYB2t/auqreky+yjTKfh1/ztnN33Il3tYWZYOUr\n" + 
    "z/7eXucip9ZP9PUUbG4HKRBTQ2mZAAX9zpNyzER2N5iWcAkkLmicnQL08NGobZ2t5cTTcd5OJhkA\n" + 
    "uH+awRY/IcIMYNBFPQDp2Yx7y9tA7xckwn6JJp0hrBvs0kuOKEtA0fgVHe7o1L2rw0Us53LqOXlc\n" + 
    "aysql5IV/iXbtGueLv2mVoCef0lJWhSg29fO2QNvjtzSoaYt2lEVVHNztCDoG70rKvN3uGer7rx+\n" + 
    "slIMenBxWC1Bjxk4cn1ImzcEJEm9bXv17M2kxcqnhazVXn5il0/1F95egA/TGcrDVQA8fvWOzn2N\n" + 
    "llnXlqxzPL2NjRFqNq03L6U9ekCAvF6vpROn+DEzI0A19fXWGRqGIUAfk0nXwGXbx7q7zcBEIuH6\n" + 
    "b2IHBNQWjZo7nJiYsAXGYjHV1dUpFAopHo87AlOplBm4nPxXWF1dLcMwNDY2Jp/PZ3KSTqctTZi+\n" + 
    "XuTnCOhgJFLUJqCfc3POQEnKzM5qMZdzhC3H1NSUslnrbf4BzetqQcm3njYAAAAASUVORK5CYII=\n";

    byte[] imageData = new sun.misc.BASE64Decoder().decodeBuffer(encodeImage);
    JLabel label = new JLabel(new ImageIcon(imageData));
    JOptionPane.showMessageDialog(null, label);
}