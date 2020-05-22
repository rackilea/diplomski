int daysInFebruary = ...; // Leap year calculation

switch (month)
{
    case 1:
        break; // Nothing to do
    case 2:
        numDay += 31; // Just add January
        break;
    case 3:
        numDay += 31 + daysInFebruary; // Add January and February
        break;
    case 4:
        numDay += 31 + daysInFebruary + 31; // Add January to March
        break;
    case 5:
        numDay += 31 + daysInFebruary + 31 + 30; // Add January to April
        break;
    // etc
    default:
        throw new IllegalArgumentException("Invalid month: " + month);
}