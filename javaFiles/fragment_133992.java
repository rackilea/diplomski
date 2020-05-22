#bevel-grey {
  -fx-color-one: #d6d6d6;
  -fx-color-two: #d9d9d9;
  -fx-color-three: #f6f6f6;

  -fx-background-color:
      linear-gradient(#f2f2f2, -fx-color-one),
      linear-gradient(#fcfcfc 0%, -fx-color-two 20%, -fx-color-one 100%),
      linear-gradient(#dddddd 0%, -fx-color-three 50%);
  -fx-background-radius: 8, 7, 6;
  -fx-background-insets: 0, 1, 2;
  -fx-text-fill: black;
  -fx-effect: dropshadow( three-pass-box, rgba(0, 0, 0, 0.6), 5, 0.0, 0, 1);
}

#bevel-grey:hover {
  -fx-color-one: #981100;
  -fx-color-two: #981100;
  -fx-color-three: #981100;
}

#bevel-grey:pressed {
  -fx-color-one: #235891;
  -fx-color-two: #235891;
  -fx-color-three: #235891;
}