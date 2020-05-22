protected class TextPane extends JPanel {

    private JLabel name;
    private JLabel icon;
    private JLabel lblClass;
    private JLabel pClass;
    private JLabel lblRole;
    private JLabel role;
    private JLabel lblStr;
    private JLabel str;
    private JLabel lblDex;
    private JLabel dex;
    private JLabel lblEnd;
    private JLabel end;
    private JLabel wiz;
    private JLabel lblHp;
    private JLabel health;
    private JLabel lblMoves;
    private JLabel movesLeft;
    private JLabel lblSkill1;
    private JButton skill1;
    private final JLabel lblSkill2;
    private final JButton skill2;
    private final JLabel lblSkill3;
    private final JButton skill3;
    private final JLabel lblSkill4;
    private final JButton skill4;

    public TextPane() {

        //add(filler);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel dash;

        name = new JLabel(MiniRPG.MiniRPG.players.get(setupPlayerIndex).getName());
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        add(name, c);

        icon = new JLabel(MiniRPG.players.get(setupPlayerIndex).getIcon());
        c.gridx = 1;
        c.gridy = 2;
        add(icon, c);

        lblClass = new JLabel("Class:");
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        add(lblClass, c);

        pClass = new JLabel(MiniRPG.players.get(setupPlayerIndex).getclass());
        c.gridx = 2;
        c.gridy = 3;
        add(pClass, c);

        lblRole = new JLabel("Role:");
        c.gridx = 1;
        c.gridy = 4;
        add(lblRole, c);

        role = new JLabel(MiniRPG.players.get(setupPlayerIndex).getRole());
        c.gridx = 2;
        c.gridy = 4;
        add(role, c);

        dash = new JLabel("--------------------STATS--------------------");
        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 5;
        add(dash, c);

        lblStr = new JLabel("Strengh:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 6;
        add(lblStr, c);

        str = new JLabel(Integer.toString(
                MiniRPG.MiniRPG.players.get(setupPlayerIndex).getStr()));
        //c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 6;
        add(str, c);

        lblDex = new JLabel("Dexterity:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 7;
        add(lblDex, c);

        dex = new JLabel(Integer.toString(
                MiniRPG.MiniRPG.players.get(setupPlayerIndex).getDex()));
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 7;
        add(dex, c);

        lblEnd = new JLabel("Endurance:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 8;
        add(lblEnd, c);

        end = new JLabel(Integer.toString(
                MiniRPG.MiniRPG.players.get(setupPlayerIndex).getEnd()));
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 8;
        add(end, c);

        lblDex = new JLabel("Wisdom:");
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 9;
        add(lblDex, c);

        wiz = new JLabel(Integer.toString(
                MiniRPG.MiniRPG.players.get(setupPlayerIndex).getWis()));
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 9;
        add(wiz, c);

        lblHp = new JLabel("HP: ");
        c.gridx = 1;
        c.gridy = 10;
        add(lblHp, c);


        health = new JLabel(Integer.toString(
                MiniRPG.MiniRPG.players.get(setupPlayerIndex).getHp()));
        c.gridx = 2;
        c.gridy = 10;
        add(health, c);

        lblMoves = new JLabel("Moves Left: ");
        c.gridx = 1;
        c.gridy = 11;
        add(lblMoves, c);

        movesLeft = new JLabel(Integer.toString(
                MiniRPG.players.get(setupPlayerIndex).getMoves()));
        c.gridx = 2;
        c.gridy = 11;
        add(movesLeft, c);

        dash = new JLabel("--------------------SKILLS--------------------");
        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 12;
        add(dash, c);

        lblSkill1 = new JLabel("Skill 1:");
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 13;
        add(lblSkill1, c);

        skill1 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill1());
        c.gridx = 2;
        c.gridy = 13;
        add(skill1, c);

        lblSkill2 = new JLabel("Skill 2:");
        c.gridx = 1;
        c.gridy = 14;
        add(lblSkill2, c);

        skill2 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill2());
        c.gridx = 2;
        c.gridy = 14;
        add(skill2, c);
        skill2.setEnabled(false);

        lblSkill3 = new JLabel("Skill 3:");
        c.gridx = 1;
        c.gridy = 15;
        add(lblSkill3, c);

        skill3 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill3());
        c.gridx = 2;
        c.gridy = 15;
        add(skill3, c);
        skill3.setEnabled(false);

        lblSkill4 = new JLabel("Skill 4:");
        c.gridx = 1;
        c.gridy = 16;
        add(lblSkill4, c);

        skill4 = new JButton(MiniRPG.players.get(setupPlayerIndex).getSkill4());
        c.gridx = 2;
        c.gridy = 16;
        add(skill4, c);
        skill4.setEnabled(false);

        skill1.addActionListener(e);
        skill2.addActionListener(e);
        skill3.addActionListener(e);
        skill4.addActionListener(e);

    }

    public void setMovesLeft(int value) {
        movesLeft.setText(Integer.toString(value));
    }

}