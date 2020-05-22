private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
    int slidervalue = jSlider1.getValue();
    if (slidervalue >= 100){
       login = true;
       jButton1.setEnabled(true);
    } else {
       // if you want to de-activate things if the slider is < 100
       login = false;
       jButton1.setEnabled(false);
    }
}