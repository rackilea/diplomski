@RunWith(PowerMockRunner.class)

@PrepareForTest({Logger.class})

@SuppressStaticInitializationFor("org.mycompany.Logger")
public Class A{
PowerMockito.mockStatic(Logger.class);
}