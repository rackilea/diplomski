public Form MakeForm(Type formType)
{
    return Activator.CreateInstance(formType) as Form;
}

Form form = MakeForm(typeof(MyFormType));