double[] feature_pieces_double = new double[feature_pieces.length];

for (int i = 0; i < feature_pieces.length; i++) {
    feature_pieces_double[i] = Double.parseDouble(feature_pieces[i]);
}

neuralNetwork.setInput(feature_pieces_double);