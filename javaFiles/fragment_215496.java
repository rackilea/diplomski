if (!flipped)
{
    glOrthof(0, screenWidth, screenHeight, 0, -1, 1); //--Device
}
else
{
    glOrthof(0, screenWidth, 0, -screenHeight, -1, 1); //--Emulator
}