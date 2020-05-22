int intDuration = (int) Math.floor(duration.toSeconds());
int durationHours = intDuration / (60 * 60);
if (durationHours > 0)
{
    intDuration -= durationHours * 60 * 60;
}
int durationMinutes = intDuration / 60;
int durationSeconds = intDuration - durationHours * 60 * 60 - durationMinutes * 60;