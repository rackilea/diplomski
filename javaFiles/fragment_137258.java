if(AiTotal2cards < 15) {
    AiCard3 = Math.random() * 12 + 1;
    AiCard3 = Math.round(AiCard3);
    AiTotalcard3 = AiCard1 + AiCard2 + AiCard3;
} else {
    AiTotalcard3 = AiCard1 + AiCard2; // be sure to always set it
}