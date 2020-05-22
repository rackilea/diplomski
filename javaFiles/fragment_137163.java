public class Monster
{
    private ImageIcon monster;
    private JButton b;

    public Monster()
    {
        monster = new ImageIcon("Monster.jpg");
        b = new JButton(monster);
        b.setIcon(monster);
    }

    public JButton getMonsterButton() {
        return b;
    }
}