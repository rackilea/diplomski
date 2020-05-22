private void authPrivs(userLevel)
{
switch(userLevel)
     case "Admin":
           break;
     case "Limited":
           buttonAdmin.setEnabled(false);
           buttonAdmin2.setEnabled(false);
           break;
}