byte[] bytes = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

int chunkSize = 4;

var chunkedBytes = bytes.Select((x, i) => new { Index = i, Value = x })
                        .GroupBy(i => i.Index / chunkSize)
                        .Select(i => i.Select(j => j.Value))
                        .Reverse().ToList();