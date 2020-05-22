import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TestMultiplePanels {

    private final UserList userList;

    private User currentUser;

    private JTextField name;

    private JTextField age;

    private JTextField index;

    private JButton prev;

    private JButton next;

    public TestMultiplePanels(UserList userList) {
        this.userList = userList;
    }

    protected void initUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel userPanel = new JPanel(new BorderLayout());
        JPanel userInfoPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Name");
        JLabel ageLabel = new JLabel("Age");
        name = new JTextField(30);
        age = new JTextField(5);
        index = new JTextField(5);
        index.setEditable(false);
        prev = new JButton("<");
        prev.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentUser(userList.previous(currentUser));
            }
        });
        next = new JButton(">");
        next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentUser(userList.next(currentUser));
            }
        });
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.anchor = GridBagConstraints.EAST;
        GridBagConstraints gbcField = new GridBagConstraints();
        gbcField.anchor = GridBagConstraints.WEST;
        gbcField.gridwidth = GridBagConstraints.REMAINDER;
        userInfoPanel.add(nameLabel, gbcLabel);
        userInfoPanel.add(name, gbcField);
        userInfoPanel.add(ageLabel, gbcLabel);
        userInfoPanel.add(age, gbcField);
        buttonPanel.add(prev);
        buttonPanel.add(index);
        buttonPanel.add(next);
        userPanel.add(userInfoPanel);
        userPanel.add(buttonPanel, BorderLayout.SOUTH);
        setCurrentUser(userList.getUsers().get(0));
        frame.add(userPanel);
        frame.pack();
        frame.setMinimumSize(frame.getPreferredSize());
        frame.setVisible(true);
    }

    private void setCurrentUser(User user) {
        currentUser = user;
        name.setText(user.getUserName());
        age.setText(String.valueOf(user.getAge()));
        index.setText(user.getIndex() + "/" + userList.getCount());
        next.setEnabled(userList.hasNext(user));
        prev.setEnabled(userList.hasPrevious(user));
    }

    public static class UserList {
        private List<User> users;
        private List<User> unmodifiableUsers;

        public UserList() {
            super();
            this.users = load();
            unmodifiableUsers = Collections.unmodifiableList(users);
        }

        public int getCount() {
            return users.size();
        }

        public List<User> getUsers() {
            return unmodifiableUsers;
        }

        private List<User> load() {
            List<User> users = new ArrayList<TestMultiplePanels.User>();
            for (int i = 0; i < 1000; i++) {
                User user = new User();
                user.setUserName("User " + (i + 1));
                user.setAge((int) (Math.random() * 80));
                user.setIndex(i + 1);
                users.add(user);
            }
            return users;
        }

        public boolean hasNext(User user) {
            return user.getIndex() - 1 < users.size();
        }

        public boolean hasPrevious(User user) {
            return user.getIndex() > 1;
        }

        public User next(User user) {
            if (hasNext(user)) {
                return users.get(user.getIndex());
            } else {
                return null;
            }
        }

        public User previous(User user) {
            if (hasPrevious(user)) {
                return users.get(user.getIndex() - 2);
            } else {
                return null;
            }
        }
    }

    public static class User {
        private String userName;
        private int age;
        private int index;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public static void main(String[] args) {
        final UserList userList = new UserList();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestMultiplePanels testMultiplePanels = new TestMultiplePanels(userList);
                testMultiplePanels.initUI();

            }
        });
    }

}