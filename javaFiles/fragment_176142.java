try {
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName() + " - " + info.getClassName());
            //You can now set the look to the one you want with something like this:
            if ("Mac".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
            }
        }
    } catch (Exception e) {
        // Forget the look and feel!           
    }