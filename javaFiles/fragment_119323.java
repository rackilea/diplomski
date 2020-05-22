JButton stopCaptureButton = new JButton("Stop");
    panel.add(stopCaptureButton);
    stopCaptureButton.setBounds(1080, 400, 80, 30);

    stopCaptureButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            EspduReceiver.stopCapture = true;
            pool.shutdown();
        }
    });