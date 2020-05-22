public PainelPrincipal(Jogo janela) {`  
    super();  
    painel = new JPanel(){  
        protected void paintComponent(java.awt.Graphics g) { 
            super.paintComponents(g); 
            try{  
                // You shouldn't be loading resources in the paint method
                // And infact, this could be achieved by using a JLabel instead
                // of creating a custom JPanel
                g.drawImage(ImageIO.read(PainelPrincipal.class.getResource("Imagens/fundo/Fundo0.jpg")), 0, 0, this);  
            }catch(IOException e){  
                e.printStackTrace();  
            } 
        };
    };  
    //...
    setLayout(new BorderLayout());
    add(painel);
}

public PainelBonus() {  
    super();  
    setBackground(new Color(0, 0, 0));  
    setBorder(null);  
    setPreferredSize(new Dimension(300, 157));  
    setLayout(null);  

    imagemMartelo = new ImageIcon(PainelBonus.class.getResource("/Imagens/bonus/bonus_martelo/bonus_martelo_0.png"));
    imagemBomba = new ImageIcon(PainelBonus.class.getResource("/Imagens/bonus/bonus_bomba/bonus_bomba_0.png"));

    JButton btnImagemMartelo = new JButton("");
    btnImagemMartelo.setBounds(10, 11, 136, 136);
    btnImagemMartelo.setIcon(imagemMartelo);
    btnImagemMartelo.setContentAreaFilled(false);
    add(btnImagemMartelo);

    JButton btnImagemBomba = new JButton("");
    btnImagemBomba.setBounds(154, 11, 136, 136);
    btnImagemBomba.setIcon(imagemBomba);
    btnImagemBomba.setContentAreaFilled(false);
    add(btnImagemBomba);
}