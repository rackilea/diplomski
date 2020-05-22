SELECT W2.ID,
       W2.Name,
       W2.Translation
FROM Words
JOIN WordSynonym ON Words.ID = WordSynonym.Synonym_ID1
JOIN Words AS W2 ON WordSynonym.Synonym_ID2 = W2.ID
WHERE Words.ID = ?;