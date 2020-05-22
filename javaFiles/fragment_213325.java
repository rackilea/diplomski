byte[] bytes = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

int chunkSize = 4;

var chunkedBytes = new List<byte[]>();

int offset = bytes.Length % chunkSize;
for (int i = bytes.Length - 1; i >= 0; i -= chunkSize)
{
    byte[] tempBytes = new byte[i < chunkSize - 1 ? offset : chunkSize];
    int index = 0;

    for (int j = tempBytes.Length - 1; j >= 0; j--)
        tempBytes[index++] = bytes[i - j];

    chunkedBytes.Add(tempBytes);
}