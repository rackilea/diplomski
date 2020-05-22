public boolean validateX(int x)
{
     return x > 0;
}

private void validateParameter(int x)
{
     if (validateX(x))
     {
         throw new IllegalArgumentException("X is invalid");
     }
}