if(site_inclusion != null)
{
    useTheSynthesizer = site_inclusion.matches(regexPattern);
}
else if(site_exclusion != null)
{
    useTheSynthesizer = ! site_exclusion.matches(regexPattern);
}
else
{
    useTheSynthesizer = true;
}