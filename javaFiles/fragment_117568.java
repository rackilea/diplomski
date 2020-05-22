settings.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                remove(createWorld);
                remove(addServer);
                repaint();

                // Get stored preferences and specific default values if they
                // do not exist
                final Preferences prefs = Preferences.userNodeForPackage(Render.class);
              soundLevel = prefs.getInt("SOUND_LEVEL", 50);
              lightLevel = prefs.getInt("LIGHT_LEVEL", 50);

              // Add sound label
                JLabel soundLabel = new JLabel("Sound: ");
                soundLabel.setBounds(170, 110, 150, 35);
                soundLabel.setForeground(Color.white);

                add(soundLabel);
                add(sound);
                sound.setBounds(210, 110, 150, 35);
                sound.setMinimum(0);
                sound.setMaximum(100);
                sound.setValueIsAdjusting(true);
                sound.setValue(soundLevel);
                sound.setToolTipText("Audio: " + soundLevel + "%");
                sound.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {

                        soundLevel = sound.getValue();

                        // Update tooltip value
                    sound.setToolTipText("Audio: " + soundLevel + "%");

                    // Save sound value in pref
                 prefs.putInt("SOUND_LEVEL", soundLevel);
                    }
                });

                // Add light label
            JLabel lightLabel = new JLabel("Light: ");
            lightLabel.setBounds(370, 110, 150, 35);
            lightLabel.setForeground(Color.white);

            add(lightLabel);
                add(light);
                light.setBounds(405, 110, 150, 35);
                light.setMinimum(0);
                light.setMaximum(100);
                light.setValueIsAdjusting(true);
                light.setValue(lightLevel);
            light.setToolTipText("Brightness: " + lightLevel + "%");

                light.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        lightLevel = light.getValue();

                        // Update tooltip value
                    light.setToolTipText("Brightness: " + lightLevel + "%");

                    // Save light value in pref
                    prefs.putInt("LIGHT_LEVEL", lightLevel);
                    }
                });
            }
        });