float gain = 0.5f;
for (int i = 0; i < audio.Length; i += 2)
{
    short val = BitConverter.ToInt16(audio, i);
    val = (short)((float)val * gain);
    Array.Copy(BitConverter.GetBytes(val), 0, audio, i, 2);
}