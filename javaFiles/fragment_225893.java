float gain = 0.5f;
for (int i = 0; i < audio.Length; i += 4)
{
    float val = BitConverter.ToSingle(audio, i);
    val *= gain;
    Array.Copy(BitConverter.GetBytes(val), 0, audio, i, 4);
}