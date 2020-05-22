chartControlButtons.add(
        new JButton("Zoom In") {{
          addActionListener(
              (ActionEvent e) -> Optional.ofNullable(getChartController()).ifPresent(s -> s.zoomIn())
          );
        }}
    );