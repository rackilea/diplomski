public void addModuleToStudent(Module module)
{
    if (modules.size() > 3)
    {
        throw new SomeAppropriateException("Cannot have more than 4 modules");
    }
    modules.add(module);
}