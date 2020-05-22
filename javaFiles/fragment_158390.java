@Override
public void onClick(View v)
{
    CheckLogin checkLogin = new CheckLogin();
    checkLogin.execute(usernam.getText(),passwordd.getText());
}